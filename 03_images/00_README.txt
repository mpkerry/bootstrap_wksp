Images

Bootstrap makes images responsive with class="img-responsive"

However, this only affects the scaling of the image on a mobile device, not the 
size of the image itself. For that, we need other tools.

The simplest approach for dealing with size is srcset:

<img
	srcset="some_image_large.jpg 1920w,
			some_image_medium.jpg 960w,
			some_image_small.jpg 480w "
	src="some_image_medium.jpg"
	alt="meaningful description of 'some image' in context of page"
/>
	
However, srcset is not supported across all browsers. Sigh. Works great in Chrome, 
not at all yet in Firefox, although theoretically version 38 of FF will
include support. IE? Ha :) Safari? Incomplete support (only x attributes, not the w attributes as above)

The picture tag, while a more versatile option, is also only supported fully in Chrome.

References

http://alistapart.com/article/responsive-images-in-practice

Availability of support varies:
http://caniuse.com/#feat=srcset
http://caniuse.com/#feat=picture

http://getbootstrap.com/css/#images
http://getbootstrap.com/css/#images-responsive
http://getbootstrap.com/css/#images-shapes