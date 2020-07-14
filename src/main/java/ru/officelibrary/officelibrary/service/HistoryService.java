package ru.officelibrary.officelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.entity.History;
import ru.officelibrary.officelibrary.repository.HistoryRepository;

import java.util.List;

@Service
@Transactional
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public History addHistory(History history){
        return historyRepository.save(history);
    }

    public History getById(long id){
        return historyRepository.findById(id).get();
    }

    public List<History> getAll(){
        return (List<History>) historyRepository.findAll();
    }

//    public List<History> search(Long id) {
//        return adminHistoryRepository.search(id);
//    }
}
