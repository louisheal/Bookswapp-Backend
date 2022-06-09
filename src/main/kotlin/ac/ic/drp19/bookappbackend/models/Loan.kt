package ac.ic.drp19.bookappbackend.models

import java.sql.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@Entity
class Loan(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    val fromUser: User,

    @ManyToOne
    val toUser: User,

    @ManyToOne
    val book: Book,

    @NotNull
    @Min(1)
    val copies: Int,

    @NotNull
    val date: Date,

    val returnDate: Date,

    @OneToMany(mappedBy = "loan")
    val returns: List<Return>
)
