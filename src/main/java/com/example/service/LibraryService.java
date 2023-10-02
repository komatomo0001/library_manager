package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Library;
import com.example.repository.LibraryRepository;

@Service
public class LibraryService {

	private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> findAll() {
        return this.libraryRepository.findAll();
    }
    
    public Library findById(Integer id) {
        Optional<Library> optionalLibrary = this.libraryRepository.findById(id);
        Library library  = optionalLibrary.get();
        return library;
    }
    
    public Library update(Integer id, LoginUser loginUser) {
        Library library = this.findById(id);
        library.setUserId(loginUser.getUser().getId());
        return this.libraryRepository.save(library);
    }
    
    public Library update(Integer id) {
        Library library = this.findById(id);
        library.setUserId(0);
        return this.libraryRepository.save(library);
    }
}
