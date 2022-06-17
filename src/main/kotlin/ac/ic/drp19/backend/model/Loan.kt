package ac.ic.drp19.backend.model

import ac.ic.drp19.backend.util.ExposeId
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonFormat
import java.sql.Date
import java.time.LocalDate
import java.util.Collections.emptyList
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@Entity
@ExposeId
class Loan(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @ManyToOne
    var fromUser: User,

    @ManyToOne
    var toUser: User,

    @ManyToOne
    var book: Book,

    @NotNull
    @Min(1)
    var copies: Int,

    @JsonFormat(pattern = "yyyy-MM-dd")
    var date: Date = Date.valueOf(LocalDate.now()),

    @OneToMany(mappedBy = "loan")
    @JsonBackReference
    var returns: List<Return> = emptyList()
)
