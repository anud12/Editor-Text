var onscroll_headerContent =[[]];

function onscrollStuff(div)
{
    function stringToAscii(s)
    {
        var ascii="";
        if(s.length>0)
            for(i=0; i<s.length; i++)
            {
                var c = ""+s.charCodeAt(i);
                while(c.length < 3)
                c = "0"+c;
                ascii += c;
            }
        return(ascii);
    }

    var divID ="#" + div.attr('id');
    var wrapperDiv = $("#wrapper-" + div.attr('id'));
    var wrapperChildsDiv = $(".wrapper-childOf-" + div.attr('id'));
    var childs = $("childOf-" + divID);
    var format = div.attr('format');

    var domPosition = wrapperDiv.position().top - wrapperDiv.height();
    
    var fireOn = true;
    var fireOff = true;

    if($("#header").length == 0)
        $("body").append("<div id= 'header'></div>");
    
    $("#header").css("position", "fixed");
    $("#header").css("top", "0px");
    $("#header").css("width", "100%");
    $("#header").css("z-index", "10000");

    var clonedDiv = wrapperDiv.clone().attr("id", stringToAscii(format));

    function toggle1(event) 
    {
        
        var topView = window.scrollY;
        var divAdjustment = 0;

        if(topView + divAdjustment> domPosition)
        {

            if(fireOn)
            {
                var formatNumber = stringToAscii(format);
                

                if($("#header > #" + formatNumber).length == 0)
                {
                    $("#header").append("<div id='"+ formatNumber + "'></div>");
                }

                if(onscroll_headerContent[formatNumber] == null)
                {
                    onscroll_headerContent[formatNumber] = [];
                }

                onscroll_headerContent[formatNumber].push(clonedDiv);

                $("#header > #" + formatNumber).replaceWith(onscroll_headerContent[formatNumber][onscroll_headerContent[formatNumber].length - 1]);

                fireOn = false;
                fireOff = true;
            }
            
        }
        else
        {
            if(fireOff)
            {
                var formatNumber = stringToAscii(format);
                if(onscroll_headerContent[formatNumber] == null)
                {
                    onscroll_headerContent[formatNumber] = [];
                }

                var index = onscroll_headerContent[formatNumber].indexOf(clonedDiv);

                if(index >= 0)
                {
                    onscroll_headerContent[formatNumber].splice( index, 1);
                }

                $("#header > #" + formatNumber).replaceWith(onscroll_headerContent[formatNumber][onscroll_headerContent[formatNumber].length - 1]);

                fireOn = true;
                fireOff = false;
            }
            
        }
    }

    $(window).bind( "scroll", toggle1 );
}
