<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["js/ticket.js"]>

    <h2 id="ticket">${ticket}</h2>
    <div id="tickets" class="row">
        <#list items as item>
            <div class="card d-inline-block" style="width: 18rem;" id="${item.id}">
                <div class="card-body">
                    <h5 class="card-title">${item.name}</h5>
                    <p class="card-text">${item.description}</p>
                    <p class="card-text"><b>Cost</b>: ${item.cost}$</p>
                    <div>
                        <a href="#" class="addToTicket btn btn-primary"><@spring.message "link.add_to_ticket" /></a>
                        <a href="/tickets/${item.id}" class=" btn btn-warning"><@spring.message "link.flight" /></a>
                        <input type="number" class="cost" name="cost" value="1">
                    </div>
                </div>
            </div>
        </#list>
    </div>

    <#include "pagination.ftlh">

</@main.renderWith>