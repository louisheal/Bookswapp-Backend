package ac.ic.drp19.backend.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.sun.istack.NotNull
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Book(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @NotNull
    var isbn: String,

    @NotNull
    var title: String,

    @JsonFormat(pattern = "yyyy-MM-dd")
    var published: Date
)
