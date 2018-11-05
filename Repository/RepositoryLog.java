package org.spu.Repository;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.spu.Login.LoginBean;


@Repository

public interface RepositoryLog extends JpaRepository<LoginBean, BigDecimal>

{

	@Query("select n from LoginBean n where n.login_name=:login_name")
public	List<LoginBean> findByName(@Param("login_name")String login_name);
	
	@Query("select n from LoginBean n where n.login_email=:login_email")
public	List<LoginBean> findByEmail(@Param("login_email")String login_email);

}
