package ac.ic.drp19.backend.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@Entity
class Ownership(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "owner_id")
    var owner: User,

    @ManyToOne
    @JoinColumn(name = "book_id")
    var book: Book,

    @NotNull
    @Min(1)
    var totalCopies: Int,

    @NotNull
    @Min(0)
    var currentCopies: Int
)
