/**
 * link_generator.groovy
 * generate index page for abcd mobile workshop
 */
 
def f = new File(".")
def srcDir = f.absolutePath
srcDir = srcDir.substring(0,srcDir.length()-1)

def dest = new File("index.html")
def pw = new PrintWriter(dest)
pw.println "<!DOCTYPE html>\n<html>\n<head>\n<title>ABCD Mobile Bootstrap WKSP - Links to exercises</title>\n"
pw.println new File("00_resources/cdn_links.txt").text
pw.println"</head>"
pw.println "<body>\n<div class=\"container\">\n"
pw.println "<div class=\"jumbotron\">\n<h1>ABCD Mobile Bootstrap WKSP</h1>\n<h2>Links to exercises</h2>\n</div>"
def counter = 0
f.eachFile { dir ->

    if (dir.isDirectory() && dir.name.charAt(0) != '.') {

        if (counter%3 == 0) {
            pw.println "<div class=\"row\">"
        }
        pw.println "<div class=\"col-sm-4\"><h3>${dir.name} </h3>"
        pw.println "<ul  class=\"list-unstyled\">"
        dir.eachFile { file ->
            if (file.name.contains(".txt") || file.name.contains(".html") || file.name.contains(".css") || file.name.contains(".js")) {
                def fileName = file.absolutePath.replace(srcDir,'')
                pw.println "<li><a href=\"$fileName\" target=\"_blank\">$file.name</a></li> "
            }
        }
        pw.println "</ul></div>"
        if (counter%3 == 2) {
            pw.println "</div><!-- end of row -->"
        }
        counter++
    }
}
pw.println "\n</div>\n</body>\n</html>"
pw.close()