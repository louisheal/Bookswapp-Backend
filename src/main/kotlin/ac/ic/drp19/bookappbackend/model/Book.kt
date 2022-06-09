package ac.ic.drp19.bookappbackend.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.sun.istack.NotNull
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Book(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @NotNull
    var isbn: String,

    @NotNull
    var title: String,

    @JsonFormat(pattern = "yyyy-MM-dd")
    var published: Date,

    @OneToMany(mappedBy = "book")
    var owners: List<Ownership> = emptyList()
)
