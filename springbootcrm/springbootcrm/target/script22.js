var entries = [];

function saveEntry() {
var name = document.getElementById("name").value;
var type = document.getElementById("type").value;
var tags = document.getElementById("tags").value.split(",");
var contacts = document.getElementById("contacts").value.split(",");

var entry = {
name: name,
type: type,
tags: tags,
contacts: contacts
};

entries.push(entry);
clearForm();
displayEntries();
}

function updateEntry() {
var index = document.getElementById("editIndex").value;
var name = document.getElementById("name").value;
var type = document.getElementById("type").value;
var tags = document.getElementById("tags").value.split(",");
var contacts = document.getElementById("contacts").value.split(",");

if (index >= 0 && index < entries.length) {
entries[index].name = name;
entries[index].type = type;
entries[index].tags = tags;
entries[index].contacts = contacts;
clearForm();
displayEntries();
}
}

function deleteEntry(index) {
if (index >= 0 && index < entries.length) {
entries.splice(index, 1);
displayEntries();
}
}

function displayEntries() {
var entriesDiv = document.getElementById("entries");
entriesDiv.innerHTML = "";

for (var i = 0; i < entries.length; i++) {
var entry = entries[i];
var entryDiv = document.createElement("div");
entryDiv.className = "entry";
entryDiv.innerHTML =
"

Name: " + entry.name + "</p>" +
"<p><strong>Type:</strong> " + entry.type + "</p>" +
"<p><strong>Tags:</strong> " + entry.tags.join(", ") + "</p>" +


has context menu