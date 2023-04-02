package com.lms.liberarymanagementsystem.Service;

import com.lms.liberarymanagementsystem.DTO.IssueBookRequestDto;
import com.lms.liberarymanagementsystem.DTO.IssueBookResponseDto;
import com.lms.liberarymanagementsystem.Entity.Book;
import com.lms.liberarymanagementsystem.Entity.LiberaryCard;
import com.lms.liberarymanagementsystem.Entity.Transaction;
import com.lms.liberarymanagementsystem.Enum.CardStatus;
import com.lms.liberarymanagementsystem.Enum.TransactionStatus;
import com.lms.liberarymanagementsystem.Repository.BookRepository;
import com.lms.liberarymanagementsystem.Repository.CardRepository;
import com.lms.liberarymanagementsystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

//        Create Transaction Object
        Transaction transaction = new Transaction();
        transaction.setTransationNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);


//        1 step
        LiberaryCard card;
        try {
             card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch(Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Invalid card id");
            transactionRepository.save(transaction);
            throw new Exception("Invalid card id");
        }

        Book book;
        try{
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch(Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Invalid book id");
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book Id");
        }

//        both card and book are valid
        transaction.setBook(book);
        transaction.setCard(card);

        if(card.getStatus() != CardStatus.ACTIVATED) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Your card is not activated");
            transactionRepository.save(transaction);
            throw new Exception("Your card is not activated");
        }

        if(book.isIssued() == true) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Sorry! Book is already issued");
            transactionRepository.save(transaction);
            throw new Exception("Sorry! Book is already issued");
        }

//        I can issue the book now
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMessage("Transaction was succussfull");
        book.setIssued(true);
        book.setCard(card);
        book.getTransactions().add(transaction);
        card.getTransactionList().add(transaction);
        card.getBooksIssued().add(book);

        cardRepository.save(card); // this will save book and transaction and card at one line

       IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
       issueBookResponseDto.setTransactionId(transaction.getTransationNumber());
       issueBookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
       issueBookResponseDto.setBookName(book.getTitle());

       return issueBookResponseDto;

    }

}
