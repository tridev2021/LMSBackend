package com.lms.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.StudyBatch;
import com.lms.repository.StudyBatchRepo;
import com.lms.service.StudBatchService;

@Service
public class StudyBatchServiceImpl implements StudBatchService {

	@Autowired
	private StudyBatchRepo sbRepo;
	
	@Override
	public List<StudyBatch> getStudyBatch() {
		return sbRepo.findAll();
	}

	@Override
	public Optional<StudyBatch> findById(Long id) {
		return (Optional<StudyBatch>) sbRepo.findById(id);
		}
	
	@Override
	public void add(StudyBatch sBatch) {
		sbRepo.save(sBatch);
	}

	@Override
	public void updateStudyBatch(StudyBatch sBatch, long bid) {
		StudyBatch sb = sbRepo.findById(bid).orElseThrow(null);
		sb.setBatchName(sBatch.getBatchName());
		sb.setCourseName(sBatch.getCourseName());
		sb.setDuration(sBatch.getDuration());
		sb.setEnrollStudent(sBatch.getEnrollStudent());
		sb.setStartDate(sBatch.getStartDate());
		sb.setEndDate(sBatch.getEndDate());
		sb.setFacultyName(sBatch.getFacultyName());
		
		sbRepo.save(sb);
		
	}

	@Override
	public void deleteStudyBatch( long bid) {
	   sbRepo.deleteById(bid);	
	}

}
