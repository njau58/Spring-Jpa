package org.spu.Login;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.spu.Repository.RepositoryLog;

@RestController

@RequestMapping(value = "/hostel-management/Controller")
public class LoginController {
	@Autowired
	RepositoryLog repositoryLog;

	
	@RequestMapping(method = RequestMethod.GET, value = "/fetchAll")

	public String getAll() {
		return repositoryLog.findAll().toString();

	}


	@RequestMapping(method = RequestMethod.GET, value = "/fetchOne")
	public LoginBean findOne(@RequestParam BigDecimal login_id) {
		return repositoryLog.findOne(login_id);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public List<LoginBean> Save(@RequestBody LoginBean Loginbean) {
		repositoryLog.save(Loginbean);

		return repositoryLog.findAll();

	}

	@RequestMapping(method = RequestMethod.POST, value = "/deleteOne")
	public List<LoginBean> delete(@RequestParam BigDecimal login_id) {
		repositoryLog.delete(login_id);

		return repositoryLog.findAll();

	}
	@RequestMapping(method = RequestMethod.POST, value = "/update")
     public List<LoginBean> update(@RequestBody LoginBean login_id){
	repositoryLog.save(login_id);

	return repositoryLog.findAll();

	}
	@RequestMapping(method = RequestMethod.POST, value = "/findByName")
    public List<LoginBean> findbyName(@RequestParam String login_name){
		return repositoryLog.findByName(login_name);

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/findByEmail")
    public List<LoginBean> findbyEmail(@RequestParam String login_email){
		return repositoryLog.findByEmail(login_email);



	}

}
