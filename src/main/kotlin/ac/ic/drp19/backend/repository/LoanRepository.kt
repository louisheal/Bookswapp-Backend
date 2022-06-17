package ac.ic.drp19.backend.repository

import ac.ic.drp19.backend.model.Loan
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface LoanRepository : CrudRepository<Loan, Long> {

    @Query("select l from Loan l where l.fromUser.id = :from_user_id")
    fun findLoansFromUser(@Param("from_user_id") fromUser: Long): List<Loan>

    @Query("select l from Loan l where l.toUser.id = :to_user_id")
    fun findLoansToUser(@Param("to_user_id") toUser: Long): List<Loan>
}
