function header()
{
    this.arrayKeys = [];
    this.elementsArray = [];

    this.addDiv = function(elementID)
    {
        var element = document.getElementById(elementID);
        var elementType = element.getAttribute("format");

        if(this.elementsArray[elementType] == null)
        {
            this.elementsArray[elementType] = [];
            this.arrayKeys.push(elementType);
        }


        var length = this.elementsArray[elementType].length;

        console.log(elementType);

        if(element == null)
        {
            return;
        }

        var pozition = element.getBoundingClientRect().top;

        for(var i = 0 ; i < length ; i++)
        {
            console.log("addElementLoop " + i);
            var div = this.elementsArray[elementType][i];
            var divPozition = div.getBoundingClientRect().top;

            if(pozition < divPozition)
            {
                insertElement(this.elementsArray[elementType], element, i);
                this.elementsArray[elementType]["topLocation"] = pozition;
                
                this.sortCategories();
                return;
            }
        }

        this.elementsArray[elementType].push(element);
        this.sortCategories();
    }

    this.sortCategories = function()
    {
        var length = this.arrayKeys.length;
        var arrayKeys = this.arrayKeys;
        var elementsArray = this.elementsArray;

        for(var i = 0 ; i < length ; i++)
        {
            var x = this.elementsArray[arrayKeys[i]]["topLocation"];
            var j = i;
            while(j > 0 && elementsArray[arrayKeys[i - 1]]["topLocation"] > x)
            {
                elementsArray[arrayKeys[i]]["topLocation"] = elementsArray[arrayKeys[i - 1]]["topLocation"]
                j = j - 1;
            }

            elementsArray[arrayKeys[i]]["topLocation"] = x;
        }
    }
    
}
function insertElement(array, element, location)
{
    location = location -1;
    var aux;
    var replacedElement = array[location];

    array[location] = element;

    for(var i = location; i < array.length ; i++)
    {
        aux = array[i];
        array[i] = replacedElement;
        replacedElement = aux;
    }

    array.push(aux);
}

var header = new header();