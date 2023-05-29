import java.nio.file.Paths
import java.io.File
import scala.jdk.CollectionConverters._

@main def run(): Unit =
  val dirs = Paths.get("examples").toFile.listFiles.toList.filter(_.isDirectory)
  println("# Kotlin by Examples\n")
  dirs.sortBy(_.getName).foreach { dir =>
    val dirname = dir.getName
    println(s"# ${dirname.drop(3)}")
    val files = dir.listFiles.toList.sortBy(_.getName)
    files.tail.foreach { file =>
      val filename = file.getName
      val filepath = filename.replaceAll(" ", "%20")
      println(s"  - [${filename.drop(3).dropRight(3)}]($dirname/$filepath)")
    }
  }
