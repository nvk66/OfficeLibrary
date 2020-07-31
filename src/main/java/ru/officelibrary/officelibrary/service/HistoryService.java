package ru.officelibrary.officelibrary.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.common.BookStatus;
import ru.officelibrary.officelibrary.dto.HistoryDto;
import ru.officelibrary.officelibrary.entity.History;
import ru.officelibrary.officelibrary.repository.HistoryRepository;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final UserService userService;
    private final BookService bookService;
    private final static String dateFormat = "yyyy-MM-dd";

    public HistoryService(HistoryRepository historyRepository, UserService userService, BookService bookService) {
        this.historyRepository = historyRepository;
        this.userService = userService;
        this.bookService = bookService;
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

    public List<History> findAllByStatsEqualsBusy(){
        return historyRepository.findAllByStatsEquals(String.valueOf(BookStatus.BUSY));
    }

    public Date getCurrentDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        return Date.valueOf(simpleDateFormat.format(calendar.getTime()));
    }

    public History createHistoryRecord(HistoryDto historyDto, long id){
        History history = new History();
        history.setUser(userService.getByID(Long.parseLong(historyDto.getUser())));
        history.setBook(bookService.get(id));
        history.setStartDate(historyDto.getStartDate());
        history.setDueDate(historyDto.getDueDate());
        history.setStats(historyDto.getStats());
        history.setId(historyDto.getHistoryId());
        return history;
    }
}
