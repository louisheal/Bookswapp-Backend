package ac.ic.drp19.bookappbackend.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@Entity
class Ownership(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    val owner: User,

    @ManyToOne
    val book: Book,

    @NotNull
    @Min(0)
    val copies: Int
)
