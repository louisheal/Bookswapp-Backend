package ac.ic.drp19.backend.repository

import ac.ic.drp19.backend.model.Return
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ReturnRepository : CrudRepository<Return, Long> {

    @Query("select r from Return r where r.loan.id = :loan_id")
    fun findReturnsOfLoan(@Param("loan_id") loanId: Long): List<Return>
}
