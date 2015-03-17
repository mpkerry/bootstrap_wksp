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
pw.println"</head>"
pw.println "<body>\n<div class=\"container\">\n"
pw.println "<div class=\"jumbotron\">\n<h1>Bootstrap Workshop</h1>\n<h2>Links to exercises</h2>\n</div>"

pw.println "<h3>Created for ABCD bootstrap wksp 3/19/2015</h3>"

pw.println "<h4>Exercises to familiarize you with the essentials that Bootstrap has to offer.</h4>"

pw.println "<a href=\"#instructions\" data-toggle=\"collapse\" aria-expanded=\"true\" aria-controls=\"longContent\">Show/Hide Instructions</a>"

pw.println "<div id=\"instructions\" class=\"collapse in\"><p>The basic idea is to work through the exercises in directory order, starting with 01-04 in ascending order, then picking through 05-08 in whatever order appeals to you. If you have time to also work through the more challenging exercises in 09 during the 90 minute workshop, well, then, you work quickly. :)</p>"

pw.println "<ul><li>Sections 01-04 are mostly about CSS: http://getbootstrap.com/css/</li>"

pw.println "<li>Sections 05-08 refer more to the javascript portion of Bootstrap, although you can accomplish much functionality with CSS and other attributes: http://getbootstrap.com/javascript/</li>"

pw.println "<li>Files are in pairs; all '*_DONE.html' files contain one possible solution; there are, of course, many others. The other html files are the starting points. All exercises can be completed with CSS classes alone, but can also instead be completed with bootstrap.js - or some combination of the 2. The solutions provided are almost exclusively CSS solutions.</li>"

pw.println "<li>Open the index file in the root of the project in a web browser so that you can see the starting and end states of the exercises (this will give you a visual reference as you work), then open the first project (e.g., '01_grid_breakpoints.html') in your favorite text editor/IDE.</li>"

pw.println "<li>You may also find it useful to consult the index page (click on the section header) and/or the 00_README.txt files in each section, as they contain information and useful links.</li></ul></div>"

pw.println "<p>Happy coding!</p>"

def counter = 0
f.eachFile { dir ->

    if (dir.isDirectory() && dir.name.charAt(0) != '.') {

        if (counter%3 == 0) {
            pw.println "<div class=\"row\">"
        }
        pw.println "<div class=\"col-sm-4\"><h3><a href=\"${dir.name}/index.html\">${dir.name.replaceAll('_',' ')}</a> </h3>"
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
pw.println "\n</div>"
pw.println new File("00_resources/cdn_js.txt").text
pw.println "\n</body>\n</html>"
pw.close()