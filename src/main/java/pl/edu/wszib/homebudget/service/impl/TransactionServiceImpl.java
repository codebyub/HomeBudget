package pl.edu.wszib.homebudget.service.impl;

import org.springframework.stereotype.Service;
import pl.edu.wszib.homebudget.dao.TransactionDao;

import pl.edu.wszib.homebudget.dto.TransactionDto;
import pl.edu.wszib.homebudget.service.TransactionMapper;
import pl.edu.wszib.homebudget.service.TransactionService;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionDao dao;
    private TransactionMapper mapper;

    public TransactionServiceImpl(TransactionDao dao, TransactionMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

/*    @Override
    public Collection<TransactionDto> showTransaction() {
        return mapper.toDTO(dao.findAll());
    }*/

    @Override
    public List<TransactionDto> list() {
        return mapper.toDTO(dao.findAll());
    }

    @Override
    public TransactionDto get(Integer integer) {
        return null;
    }

    @Override
    public TransactionDto create(TransactionDto dto) {
        return null;
    }

    @Override
    public TransactionDto update(TransactionDto dto) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
