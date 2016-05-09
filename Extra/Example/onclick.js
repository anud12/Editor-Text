function onclickStuff(div)
{
    var divID ="#" + div.attr('id');
    var wrapperDiv = $("#wrapper-" + div.attr('id'));
    var wrapperChildsDiv = $(".wrapper-childOf-" + div.attr('id'));
    var childs = $("childOf-" + divID);

    function toggle1(event) 
    {
        wrapperChildsDiv.toggle(700);
        wrapperDiv.css( 'cursor', 'pointer' );
    }

    wrapperDiv.bind( "tap", toggle1 );
    wrapperDiv.bind( "click", toggle1 );
}