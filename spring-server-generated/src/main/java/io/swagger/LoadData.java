package io.swagger;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Account;
import io.swagger.repository.RepositoryUtility;

/**
 * @Description: This class initialize on application startup to load account data from data.json file 
 * 
 * */
@Service
public class LoadData {
	
	private static final Logger log = LoggerFactory.getLogger(LoadData.class);

	@Value("${json.data.file}")
	private String jsonDataFile;
	
	@PostConstruct
	public void init() throws IOException {
		log.info("Function call Post Construct: JSON Data Folder: " + jsonDataFile);
		
		List<Account> accountList = new ObjectMapper()
									.readValue(ResourceUtils.getFile(jsonDataFile), 
												new TypeReference<List<Account>>(){});
		log.info("Size of load Account data: " + accountList.size());
		
		
		  accountList.forEach(account -> RepositoryUtility.saveAccount(account));
		  log.info("Saved account Data in DAO : " +
		  RepositoryUtility.getAllAccounts().size());
		 
	}
}
