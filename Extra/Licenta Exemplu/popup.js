function popup(elementID, popupID) 
{
    var div = document.getElementById(elementID);
    var popup = document.getElementById(popupID);

    popup.style.display = "none";
    popup.style.position = "absolute";
    popup.style.top = div.getBoundingClientRect().bottom;
    popup.style.left = div.getBoundingClientRect().left;

    var isShown = false;
    function popupEvent(event)
    {
        console.log("EVENT");
        if(isShown)
        {
            hidePopup()
            isShown = false;
        }
        else
        {
            showPopup();
            isShown = true;
        }
    }

    function hidePopup()
    {
        popup.style.display = "none";
    }
    function showPopup()
    {
        popup.style.display = "inline";
    }

    function resize(event)
    {
        popup.style.position.top = div.getBoundingClientRect().bottom;
        popup.style.position.left = div.getBoundingClientRect().left;
    }

    div.addEventListener("click", popupEvent);
    window.addEventListener("resize", resize);
}