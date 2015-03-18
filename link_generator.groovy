/**
 * link_generator.groovy
 * generate index page for abcd mobile workshop
 */
 
def f = new File(".")
def srcDir = f.absolutePath
srcDir = srcDir.substring(0,srcDir.length()-1)

def dest = new File("index.html")
def pw = new PrintWriter(dest)
pw.println "<!DOCTYPE html>\n<html>\n<head>\n<title>Bootstrap WKSP - Links to exercises</title>\n"
pw.println new File("00_resources/cdn_css.txt").text
pw.println "<meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0\">"
pw.println"<style>.hider { font-size: .65em }</style>\n</head>"
pw.println "<body>\n<div class=\"container\">\n"
pw.println "<div class=\"jumbotron\">\n<h1>Bootstrap Workshop</h1>\n<h2>Instructions, Resources, Tools, and Links to exercises</h2>\n</div>"

pw.println "<h3>Created for ABCD bootstrap wksp 3/19/2015</h3>"

pw.println "<h4>Exercises to familiarize you with the essentials that Bootstrap has to offer.</h4>"

pw.println new File("tools.html").text

pw.println new File("instructions.html").text

pw.println new File ("links.html").text

pw.println "<h3>Happy coding!</h3>"

def counter = 0
f.eachFile { dir ->

    if (dir.isDirectory() && dir.name.charAt(0) != '.') {

        if (counter%3 == 0) {
            pw.println "<div class=\"row\">"
        }
        pw.println "<div class=\"col-sm-4\"><h3><a href=\"${dir.name}/index.html\" target=\"_blank\">${dir.name.replaceAll('_',' ')}</a> </h3>"
        pw.println "<ul  class=\"list-unstyled\">"
        dir.eachFile { file ->
            if ((file.name.contains(".txt") || file.name.contains(".html") || file.name.contains(".css") || file.name.contains(".js")) &&
                !file.name.contains("index") && !file.name.contains("READ")) {
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
pw.println "\n</div>"
pw.println new File("00_resources/cdn_js.txt").text
pw.println "\n</body>\n</html>"
pw.close()