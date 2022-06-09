package ac.ic.drp19.bookappbackend.models

import java.sql.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@Entity
class Return(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @ManyToOne
    val loan: Loan,

    @NotNull
    @Min(1)
    val copies: Int,

    @NotNull
    val published: Date
)
