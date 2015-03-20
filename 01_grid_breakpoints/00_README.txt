-Bootstrap grid system and break points

Bootstrap uses a 12-column wide grid system wrapped inside a container, which can be organized in any way you wish. By default all elements are set to full width: 12 columns wide.

Bootstrap also uses 3 break points, with 4 different form factors:
*xs : phone, up to 768px wide
*sm : vertical tablet, 769px and up 
*md : horizontal tablet, 992px and up
*lg : desktop, 1200px and up

The 'and up' means that unless you specify otherwise, when you apply 'md' to an element, it will apply to 'md' and 'lg'. Similarly, when you apply 'sm' to an element, it applies to 'sm', 'md' and 'lg' form factors. By default, xs is applied to all elements

The syntax for applying this system is class="col-<size>-<numColumns>"

Thus, the default is "col-xs-12"

http://getbootstrap.com/css/#grid-options

Bootstrap also allows you to wrap up to 12 columns in a div with class="row". These row and column options can be combined with rows to create any arrangement of boxes desired on the page

We'll go through a number of common permutations in the exercises: 2, 3, 4, 5, 6 columns, and some nesting scenarios, and how these can flow through the different form factors.

 
-RESOURCES:

see 00_resources/cdn_js.txt and 00_resources/cdn_js.txt for quick copy/paste of js and css resources

-Files

