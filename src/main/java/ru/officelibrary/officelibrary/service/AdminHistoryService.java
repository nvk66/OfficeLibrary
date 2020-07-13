package ru.officelibrary.officelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.entity.History;
import ru.officelibrary.officelibrary.repository.AdminHistoryRepository;

import java.util.List;

@Service
@Transactional
public class AdminHistoryService {
    @Autowired
    private AdminHistoryRepository adminHistoryRepository;

    public AdminHistoryService(AdminHistoryRepository adminHistoryRepository) {
        this.adminHistoryRepository = adminHistoryRepository;
    }

    public History addHistory(History history){
        return adminHistoryRepository.save(history);
    }

    public History getById(long id){
        return adminHistoryRepository.findById(id).get();
    }

    public List<History> getAll(){
        return (List<History>) adminHistoryRepository.findAll();
    }

//    public List<History> search(Long id) {
//        return adminHistoryRepository.search(id);
//    }
}
