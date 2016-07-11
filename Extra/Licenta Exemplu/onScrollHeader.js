var onscroll_headerContent =[[]];

function onScrollHeader(element)
{
	function stringToAscii(s)
    {
        var ascii="";
        if(s.length>0)
        {
            for(i=0; i<s.length; i++)
            {
                var c = ""+s.charCodeAt(i);
                while(c.length < 3)
                c = "0"+c;
                ascii += c;
            }
        }
        return(ascii);
    }

    var div = document.getElementById(element);
    var divID ="" + div.getAttribute('id');
    var wrapperDiv = document.getElementById("wrapper-" + div.getAttribute('id'));
    var wrapperChildsDiv = document.getElementById("wrapper-childOf-" + div.getAttribute('id'));
    var childs = document.getElementById("childOf-" + divID);
    var format = div.getAttribute('format');

    var domPosition = div.getBoundingClientRect().top;
    
    var fireOn = true;
    var fireOff = true;

    //Check if header exists, if not create it
    var header = document.getElementById("header");
    if(header == null)
    {
        var header = document.createElement("div");
        header.setAttribute("id","header");
        document.body.appendChild(header);
        header.style.position = "fixed";
        header.style.top = "0px" ;
        header.style.width = "100%";
        header.style.zIndex = "10000";
    }
        
    var clonedDiv = wrapperDiv.cloneNode(true);

    function toggle1(event) 
    {
        var topView = window.scrollY;
        var divAdjustment = 0;

        if(topView + divAdjustment + header.getBoundingClientRect().bottom> domPosition)
        {
            if(fireOn)
            {
                var formatNumber = stringToAscii(format);
                
                var headerDiv = document.getElementById("header-" + formatNumber);

                if(headerDiv == null)
                {
                    headerDiv = document.createElement("div");
                    headerDiv.setAttribute("id","header-" + formatNumber);
                    header.appendChild(headerDiv);
                }

                if(onscroll_headerContent[formatNumber] == null)
                {
                    onscroll_headerContent[formatNumber] = [];
                }

                onscroll_headerContent[formatNumber].push(clonedDiv);

                while (headerDiv.firstChild) 
                {
                    headerDiv.removeChild(headerDiv.firstChild);
                }

                if(onscroll_headerContent[formatNumber].length > 0)
                {
                    headerDiv.appendChild( onscroll_headerContent[formatNumber][onscroll_headerContent[formatNumber].length - 1] );
                }

                fireOn = false;
                fireOff = true;
            }   
        }
        else
        {
            if(fireOff)
            {
                var formatNumber = stringToAscii(format);

                var headerDiv = document.getElementById("header-" + formatNumber);

                if(onscroll_headerContent[formatNumber] == null)
                {
                    onscroll_headerContent[formatNumber] = [];
                }

                var index = onscroll_headerContent[formatNumber].indexOf(clonedDiv);

                if(index >= 0)
                {
                    onscroll_headerContent[formatNumber].splice( index, 1);
                }

                while (headerDiv.firstChild) 
                {
                    headerDiv.removeChild(headerDiv.firstChild);
                }

                if(onscroll_headerContent[formatNumber].length > 0)
                {
                    headerDiv.appendChild( onscroll_headerContent[formatNumber][onscroll_headerContent[formatNumber].length - 1] );
                }

                fireOn = true;
                fireOff = false;
            }
            
        }
    }

    window.addEventListener("scroll", toggle1);
}
