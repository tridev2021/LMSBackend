package com.lms.service;

import java.util.List;
import java.util.Optional;

import com.lms.model.StudyBatch;

public interface StudBatchService {
	
    public List<StudyBatch> getStudyBatch();
   
    public Optional<StudyBatch> findById(Long id);
	
	public void add(StudyBatch sBatch);
	
	public void updateStudyBatch(StudyBatch sBatch, long bid);
	
	public void deleteStudyBatch( long bid);
	
}