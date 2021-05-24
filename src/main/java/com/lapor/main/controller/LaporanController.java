package com.lapor.main.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lapor.main.entity.Laporan;
import com.lapor.main.entity.User;
import com.lapor.main.repository.LaporanRepository;
import com.laporan.main.utility.FileUtility;

@RestController
@RequestMapping("/lapor")
public class LaporanController {

	@Autowired
	LaporanRepository laporRepo;
	
	@GetMapping("/")
	public Laporan getAllLaporan (@RequestBody Laporan laporan){
	return (Laporan) laporRepo.findAll();
	}

	
	
	@PostMapping("/add/")
	public String addlaporan(@RequestBody Laporan laporan){
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		  
//        
//        String uploadDir = "laporan-photos/" ;
//        
//        FileUtility.saveFile(uploadDir, fileName, file);
// 
//        laporan.setGambarBukti("/"+ uploadDir + fileName);
        
		laporRepo.save(laporan);
		return "Berhasil Simpan";
	}

	
	
}
