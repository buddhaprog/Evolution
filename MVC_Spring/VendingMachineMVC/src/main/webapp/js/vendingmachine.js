// Document ready function
var currentMoney = 0.00;
var moneyTest = 0.00;
$(document).ready(function () {
    loadInventory();
    $('#insertMoney-button').click(function (event) {
        event.preventDefault();

        $.ajax({
            type: 'POST',
            url: 'change',
            data: JSON.stringify({
                money: $('#moneySubmit').val()

            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            clearMoneyTableFrag();
        });
    });

});
$('#moneySubmit-button').click(function (event) {
    event.preventDefault();
    currentMoney = 0;
    currentMoney = currentMoney + parseFloat($('#moneySubmit').val());
    if (isNaN(currentMoney)) {
        currentMoney = 0.00;
    }
    $('#input-money').text(currentMoney);
});

function clearMoneyTable() {
    $('#money').empty();


}
function clearMoneyTableFrag() {
    $('#input-money').empty();
    $('#input-money').text('0.00');


}
function loadMoneyTable() {
    var mTableData = $('money');
    $.ajax({
        url: '/change'
    }).success(function (data, status) {
        $.each(data, function (calc) {
            mTableData.append($('<td>')
                    .append($('money')
                            .attr({'money': calc.money})
                            .text('money')
                            )
                    );
        });
    });
}

function loadInventory() {

    $.each(inventoryData, function (index, inventory) {
        var slot = $('#item' + inventory.inventoryId);
        slot.attr({'price': inventory.price, 'count': inventory.count, 'name': inventory.inventoryName, 'data-toggle': 'modal', 'data-target': '#vendingModal'});

        $.each(inventoryData, function (index, inventory) {
            var itemTag = $('#itemtag' + inventory.inventoryId);
            itemTag.append($('#itemTag'+ inventory.inventoryId)
                    .text('$' + inventory.price));
        });

    });

}

//this gives all the information and does the vending
$('.inventory-img').click(function () {

    $('#vendingModal').modal('show');

    var inventoryId = this.id;
    var currentImage = $(this);
    var modal = $('#vendingModal');
    moneyTest = 0;
    moneyTest = moneyTest + parseFloat($('#input-money').text());
    var countTest = parseInt(currentImage.attr('count'));
    if (countTest <= 0) {
        alert('Sorry out of Item');
    }
    else if (moneyTest <= 0) {
        alert('Sorry, you have not inserted enough money');
    }

    else
    {
        $.ajax({
            type: "POST",
            url: 'change/' + currentImage.attr('price') + '/' + $('#input-money').text()

        }).success(function (changeReturn) {
            modal.find('#money').text($('#input-money').text());
            modal.find('#inventory-id').text(inventoryId);
            modal.find('#inventory-name').text(currentImage.attr('name'));
            modal.find('#inventory-price').text(currentImage.attr('price'));
            var currentCount = parseInt(currentImage.attr('count'));
            currentCount--;
            currentImage.attr('count', currentCount);
            modal.find('#inventory-count').text(currentImage.attr('count'));
            modal.find('#change-money').text(changeReturn);

            clearMoneyTableFrag();
        });
        return false;

    }
});

var inventoryData = [
    {
        inventoryId: 1,
        inventoryName: "3 Musketeers",
        price: 1,
        count: 5
    },
    {
        inventoryId: 2,
        inventoryName: "C4",
        price: 3,
        count: 5
    },
    {
        inventoryId: 3,
        inventoryName: "5th Avenue",
        price: 1,
        count: 5
    },
    {
        inventoryId: 4,
        inventoryName: "Protien Powder",
        price: 5,
        count: 5
    },
    {
        inventoryId: 5,
        inventoryName: "Reese's cup",
        price: 1,
        count: 5
    },
    {
        inventoryId: 6,
        inventoryName: "Mounds",
        price: 1.5,
        count: 5
    },
    {
        inventoryId: 7,
        inventoryName: "UltraMet MRS",
        price: 4.5,
        count: 5
    },
    {
        inventoryId: 8,
        inventoryName: "Snickers",
        price: 1.25,
        count: 5
    },
    {
        inventoryId: 9,
        inventoryName: "Thingamajig",
        price: 1.75,
        count: 5
    }
];

