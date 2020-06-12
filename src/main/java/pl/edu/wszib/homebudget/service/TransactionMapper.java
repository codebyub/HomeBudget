package pl.edu.wszib.homebudget.service;

import org.mapstruct.Mapper;

import pl.edu.wszib.homebudget.domain.Transaction;
import pl.edu.wszib.homebudget.dto.TransactionDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {


    Transaction toDTO(TransactionDto transactionDto);

    TransactionDto toDB(Transaction transaction);

    List<TransactionDto> toDTO(List<Transaction> transactionList);

}
