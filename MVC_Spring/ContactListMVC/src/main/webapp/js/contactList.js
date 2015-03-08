$(document).ready(function () {
    loadContacts();

    // onclick handler for add button
    $('#add-button').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'contact',
            data: JSON.stringify({
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                company: $('#add-company').val(),
                phone: $('#add-phone').val(),
                email: $('#add-email').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            $('#add-first-name').val('');
            $('#add-last-name').val('');
            $('#add-company').val('');
            $('#add-phone').val('');
            $('#add-email').val('');
            loadContacts();
        });
    });

    // onclick handler for edit button
    $('#edit-button').click(function (event) {
        // prevent the button press from submitting the whole page
        event.preventDefault();

        // Ajax call - 
        // Method - PUT
        // URL - contact/{id}
        // Just reload all of the Contacts upon success
        $.ajax({
            type: 'PUT',
            url: 'contact/' + $('#edit-contact-id').val(),
            data: JSON.stringify({
                contactId: $('#edit-contact-id').val(),
                firstName: $('#edit-first-name').val(),
                lastName: $('#edit-last-name').val(),
                company: $('#edit-company').val(),
                phone: $('#edit-phone').val(),
                email: $('#edit-email').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadContacts();
        });
    });
    $('#search-button').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'search/contacts',
            data: JSON.stringify({
                firstName: $('#search-first-name').val(),
                lastName: $('#search-last-name').val(),
                company: $('#search-company').val(),
                phone: $('#search-phone').val(),
                email: $('#search-email').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'

            },
            'dataType': 'json'

        }).success(function (data, status) {
            $('#search-first-name').val('');
            $('#search-last-name').val('');
            $('#search-company').val('');
            $('#search-phone').val('');
            $('#search-email').val('');
            fillContactTable(data, status);
        });

    });
});
// =========
// FUNCTIONS
// =========
// 
// loads contacts into summary table
function loadContacts() {

    // clear the table so we don't repeat information

    // iterate through each of the JSON objects in the test data and render
    // them into the table
    $.ajax({
        url: 'contacts'
    }).success(function (data, status) {
        fillContactTable(data, status);

        $.ajax({
            url: 'numcontacts'
        }).success(function (numContacts, status) {
            $('#num-contacts').text(numContacts);
            alert('You Now Have ' + numContacts + ' contacts in your database. ');
        });

    });
}

function fillContactTable(contactList, status) {
    clearContactTable();

    // grab HTML element into which we're going to load the data
    var cTable = $('#contentRows');
    $.each(contactList, function (index, contact) {
        cTable.append($('<tr>')
                .append($('<td>')
                        .append($('<a>')
                                .attr({'data-contact-id': contact.contactId, 'data-toggle': 'modal', 'data-target': '#detailsModal'})
                                .text(contact.firstName + ' ' + contact.lastName)
                                )
                        )
                .append($('<td>').text(contact.company))
                .append($('<td>')
                        .append($('<a>')
                                .attr({'data-contact-id': contact.contactId, 'data-toggle': 'modal', 'data-target': '#editModal'})
                                .text('Edit')
                                )
                        )
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deleteContact(' + contact.contactId + ')'
                                })
                                .text('Delete')
                                )
                        )
                );
    });


}



function deleteContact(id) {
    var answer = confirm("Do you really want to delete this contact?");

    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'contact/' + id
        }).success(function () {
            loadContacts();
        });
    }
}

// clear all content rows from the summary table
function clearContactTable() {
    $('#contentRows').empty();
}

// This code runs in response to show.bs.modal event for the details Modal
$('#detailsModal').on('show.bs.modal', function (event) {
    // get the element that triggered the event
    var element = $(event.relatedTarget);
    var contactId = element.data('contact-id');
//data( is tied to the data- up in the load contacts section
    var modal = $(this);

    // make an ajax call to get contact information for given contact id
    // this is a GET request to contact/{id}
    // upon success, put the returned JSON data into the modal dialog
    $.ajax({
        type: 'GET',
        url: 'contact/' + contactId
    }).success(function (contact) {
        modal.find('#contact-id').text(contact.contactId);
        modal.find('#contact-firstName').text(contact.firstName);
        modal.find('#contact-lastName').text(contact.lastName);
        modal.find('#contact-company').text(contact.company);
        modal.find('#contact-phone').text(contact.phone);
        modal.find('#contact-email').text(contact.email);
    });
});

// This code runs in response to the show.hs.modal event for the edit Modal
$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var contactId = element.data('contact-id');

    var modal = $(this);

    $.ajax({
        type: 'GET',
        url: 'contact/' + contactId
    }).success(function (contact) {
        modal.find('#contact-id').text(contact.contactId);
        modal.find('#edit-contact-id').val(contact.contactId);
        modal.find('#edit-first-name').val(contact.firstName);
        modal.find('#edit-last-name').val(contact.lastName);
        modal.find('#edit-company').val(contact.company);
        modal.find('#edit-email').val(contact.email);
        modal.find('#edit-phone').val(contact.phone);
    });
});


// TEST DATA
var testContactData = [
    {
        contactId: 1,
        firstName: "Susan",
        lastName: "Williams",
        company: "IBM",
        email: "swilliams@ibm.com",
        phone: "555-1212"
    },
    {
        contactId: 2,
        firstName: "George",
        lastName: "Smith",
        company: "EMC",
        email: "smith@emc.com",
        phone: "555-1234"
    },
    {
        contactId: 3,
        firstName: "Chuck",
        lastName: "Knobloch",
        company: "3M",
        email: "chuck@3m.com",
        phone: "555-5656"
    }
];

var dummyDetailsContact =
        {
            contactId: 42,
            firstName: "Kent",
            lastName: "Hrbek",
            company: "3M",
            email: "kent@3m.com",
            phone: "444-6798"
        };

var dummyEditContact =
        {
            contactId: 53,
            firstName: "Kirby",
            lastName: "Pucket",
            company: "Sun",
            email: "kirby@sun.com",
            phone: "333.4455"
        };