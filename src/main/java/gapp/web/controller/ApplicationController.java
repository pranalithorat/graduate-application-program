package gapp.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import gapp.model.Application;
import gapp.model.ApplicationStatus;
import gapp.model.Department;
import gapp.model.EducationalBackground;
import gapp.model.Program;
import gapp.model.User;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.UserDao;

@Controller
@SessionAttributes("application")
public class ApplicationController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ApplicationDao applicationDao;

	@Autowired
	DepartmentDao deptDao;

	@Autowired
	private ServletContext context;

	@RequestMapping(value = "/user/viewDetails.html", method = RequestMethod.GET)
	public String viewDetails(ModelMap models, @RequestParam Integer id1, @RequestParam Integer id2) {

		// List<Application> a = applicationDao.getApplication(id);
		models.put("application", applicationDao.getApp(id1));
		models.put("app", applicationDao.getApplication(id1));

		return "/user/viewDetails";

	}

	/*---------------------------------------Add  application form---------------------------------------------------*/

	@RequestMapping(value = "/user/deptPrgm.html", method = RequestMethod.GET)
	public String viewDept(@RequestParam Integer id, ModelMap models, @RequestParam Integer errors) {
		List<Department> deptList = deptDao.getDepts();
		models.put("deptList", deptList);
		if (errors != null) {
			models.put("errors", 1);
		} else {
			models.put("errors", null);
		}
		models.put("id", id);
		models.put("application", new Application());
		return "user/deptPrgm";
	}

	@RequestMapping(value = "/user/deptPrgm.html", method = RequestMethod.POST)
	public String viewDept(@RequestParam Integer errors, @RequestParam Integer id, @RequestParam MultipartFile file,
			@ModelAttribute Application application, ModelMap models) throws IllegalStateException, IOException {

		Integer deptId = application.getDepartment().getDeptId();
		String prgmName = application.getProgram().getProgramName();
		if (deptId != null && prgmName != null) {
			Department dept = applicationDao.getDeptId(deptId);
			application.setDepartment(dept);

			Program prgm = applicationDao.getPrgmId(prgmName);
			application.setProgram(prgm);
			User user = userDao.getUser(id);
			application.setUser(user);

			File file1 = new File(context.getRealPath("/WEB-INF/files"));

			if (!file1.exists()) {
				if (file1.mkdir()) {

					file.transferTo(new File(context.getRealPath("/WEB-INF/files"),
							"transcript" + application.getAppId() + file.getOriginalFilename()));
					application.setFilename("transcript" + file.getOriginalFilename());
				}

			} else {
				file.transferTo(new File(context.getRealPath("/WEB-INF/files"),
						"transcript" + application.getAppId() + file.getOriginalFilename()));
				application.setFilename("transcript" + application.getAppId() + file.getOriginalFilename());

			}

			Application savedApp = applicationDao.saveApplication(application);

			models.put("appId", savedApp.getAppId());

			return "redirect:/user/addEduBck.html";
		} else {
			models.put("errors", 1);
			return "redirect:/user/deptPrgm.html?id=" + id;
		}

	}

	@RequestMapping(value = "/user/programs.html", method = RequestMethod.GET)
	public @ResponseBody String viewPrgm(@RequestParam(value = "deptId", required = true) Integer deptId,
			ModelMap models) {

		List<Program> prgmList = deptDao.getProgramsByDeptId(deptId);
		List<String> strList = new ArrayList<String>();
		for (Program p : prgmList) {
			strList.add(p.getProgramName());
		}
		String s = new Gson().toJson(strList);
		models.put("application", new Application());

		return s;
	}

	/*-----------------------------------------addEducational Background-------------------------------*/

	@RequestMapping(value = "/user/addEduBck.html", method = RequestMethod.GET)
	public String addNewEducation(ModelMap models, @RequestParam Integer appId) {

		List<EducationalBackground> eduBacks = applicationDao.getEducationalBckgrnd(appId);
		models.put("eduBacks", eduBacks);
		models.put("appId", appId);
		models.put("education", new EducationalBackground());

		return "user/addEduBck";

	}

	@RequestMapping(value = "/user/addEduBck.html", method = RequestMethod.POST)
	public String addNewEducation(@RequestParam Integer appId, @RequestParam String action) {

		Application app = applicationDao.getApp(appId);

		if (action.equals("Save")) {

		} else if (action.equals("Submit")) {

			ApplicationStatus as = new ApplicationStatus();
			as.setStatus("New");
			as.setAppId(app);
			ApplicationStatus savedAppStatus = applicationDao.saveApplicationStatus(as);
			app.setStatus(savedAppStatus);
			app.setDateSubmitted(new Date());
			applicationDao.saveApplication(app);
		}
		Integer userId = app.getUser().getId();
		return "redirect:/user/student.html?id=" + userId;

	}

	// --------------------------------Delete Degree
	// -------------------------------------------------------------//

	@RequestMapping("/user/deleteEdu.html")
	public String deleteEduBckGrnd(@RequestParam Integer eduId, @RequestParam Integer appId,
			@RequestParam Integer add) {
		@SuppressWarnings("unused")
		int result = applicationDao.deleteEduBckGrnd(eduId);

		if (add == 1) {
			return "redirect:/user/addEduBck.html?appId= " + appId;
		} else if (add == 2) {
			return "redirect:editApplication.html?appId=" + appId;
		}
		return null;
	}

	/*--------------------------------------------Edit Application------------------------------------------------------*/

	@RequestMapping(value = "/user/editApplication", method = RequestMethod.GET)
	public String editDepartment(ModelMap models, @RequestParam Integer appId) {

		Application app = applicationDao.getApp(appId);
		List<Program> prgmList = applicationDao.getProgram(app.getDepartment().getDeptId());
		models.put("prgmList", prgmList);
		List<EducationalBackground> eduBacks = applicationDao.getEducationalBckgrnd(appId);
		models.put("eduBacks", eduBacks);
		models.put("appId", appId);
		models.put("application", app);

		return "user/editApplication";
	}

	@RequestMapping(value = "/user/editApplication", method = RequestMethod.POST)
	public String editDepartment(@RequestParam Integer appId, @RequestParam MultipartFile file,
			@ModelAttribute Application application, ModelMap models) throws IllegalStateException, IOException {

		String prgmName = application.getProgram().getProgramName();
		if (prgmName != null) {

			Program prgm = applicationDao.getPrgmId(prgmName);
			application.setProgram(prgm);

			File file1 = new File(context.getRealPath("/WEB-INF/files"));

			if (!file1.exists()) {
				if (file1.mkdir()) {

					file.transferTo(new File(context.getRealPath("/WEB-INF/files"),
							"transcript" + application.getAppId() + file.getOriginalFilename()));

					application.setFilename("transcript" + application.getAppId() + file.getOriginalFilename());
				}

			} else {
				file.transferTo(new File(context.getRealPath("/WEB-INF/files"),
						"transcript" + application.getAppId() + file.getOriginalFilename()));
				application.setFilename("transcript" + application.getAppId() + file.getOriginalFilename());

			}
			Application savedApp = applicationDao.saveApplication(application);

			models.put("appId", savedApp.getAppId());
			return "redirect:/user/addEduBck.html";
		} else {

			return "redirect:/user/editApplication.html";
		}
	}

	/*-----------------------------------------Upload and Download---------------------------------------------*/

	private File getFileDirectory() {
		String path = context.getRealPath("/WEB-INF/files");
		return new File(path);
	}

	@RequestMapping("/user/download.html")
	public String download(HttpServletResponse response, @RequestParam Integer id) throws IOException {

		String fileName = applicationDao.getApp(id).getFilename();
		// File file = null;
		response.setContentType("text/plain");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName + "");

		// read from file

		FileInputStream in = new FileInputStream(new File(getFileDirectory(), fileName));

		// writing into file
		OutputStream out = response.getOutputStream();
		byte buffer[] = new byte[2048];
		int bytesRead;
		while ((bytesRead = in.read(buffer)) > 0)
			out.write(buffer, 0, bytesRead);
		in.close();

		return null;
	}

	/*----------------------------------Add more Education--------------------------------------**/

	@RequestMapping(value = "user/addMoreEdu.html", method = RequestMethod.GET)
	public String addNewEduBck(@RequestParam Integer appId, @RequestParam Integer add, ModelMap models) {
		models.put("education", new EducationalBackground());
		models.put("appId", appId);
		models.put("add", add);
		return "user/addMoreEdu";

	}

	@RequestMapping(value = "user/addMoreEdu.html", method = RequestMethod.POST)
	public String addNewEduBck(@RequestParam Integer appId, @RequestParam Integer add,
			@ModelAttribute EducationalBackground education) {

		Application app = applicationDao.getApp(appId);

		education.setApplicationId(app);

		applicationDao.saveEducationalBackground(education);
		if (add == 1) {
			return "redirect:addEduBck.html?appId=" + appId;
		} else if (add == 2) {
			return "redirect:addEduBck.html?appId=" + appId;
		}
		return null;

	}

}
