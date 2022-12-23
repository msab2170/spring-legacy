package com.recsee.report.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.recsee.report.dto.*;
import com.recsee.report.exception.FileContentFormatException;
import com.recsee.report.exception.FileFormatException;
import com.recsee.report.mapper.UserMapper;
import com.recsee.report.vo.User;

@Service
public class UserService {
	
	private final UserMapper userMapper;

	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	
	public List<UserDto> findAllUsers() {
		List<User> UserList = userMapper.findAllUsers();
		List<UserDto> UdList = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy년MM월dd일 hh시m분");
		for (User user : UserList) {
			UdList.add(new UserDto(
					user.getId(), 
					user.getPwd(), 
					user.getName(), 
					user.getLevel(), 
					user.getDesc(), 
					String.valueOf(sdf.format(user.getRegDate())))
			);
		}		
		return UdList;
	}
	
	public FileReadResult insertUsers(MultipartFile file) throws Exception {
		
		String fileName = file.getOriginalFilename();
		
		if (fileName == null || !fileName.split("\\.")[1].equals("dbfile")) {
			throw new FileFormatException();
		} else if (file.isEmpty()) {
			throw new FileContentFormatException();
		}
		
		FileReadResult result = new FileReadResult();
		
        try (
            InputStream is = file.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        ){
	
            String line = null;
            int idx = 1;

            while ((line = br.readLine()) != null) {
            	
                try {
                    userMapper.insertUser(new User(line.split("/")));
                    result.readSuccess();
                } catch (Exception e) {
                	e.printStackTrace();
                    result.addFailLine(idx, line);
                } finally { idx++; }
                
            }
            
        } catch(IOException e) { 
        	throw new Exception(); 
        } 
      
		return result;	
	}
	
	public List<UserDto> findUsersInPage(int limit, int offset) {
		List<User> UserList = userMapper.findUsersInPage(limit, offset);
		List<UserDto> UdList = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy년MM월dd일 hh시m분");
		for (User user : UserList) {
			UdList.add(new UserDto(
					user.getId(), 
					user.getPwd(), 
					user.getName(), 
					user.getLevel(), 
					user.getDesc(), 
					String.valueOf(sdf.format(user.getRegDate())))
			);
		}		
		return UdList;
	}
}
