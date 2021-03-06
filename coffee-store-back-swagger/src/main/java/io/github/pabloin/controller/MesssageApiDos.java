package io.github.pabloin.controller;


import java.util.List;

import io.github.pabloin.model.Message;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "messagedos", description = "the message API")
@RequestMapping("/messagedos")
public interface MesssageApiDos {

	//--------- GET ALL
	@Operation(summary = "Get all messages", description = "Returns all messages", responses = {
		@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Message.class))) }
	)
	@GetMapping(value = "", produces = { "application/json" })
	ResponseEntity<List<Message>> getAll();

	//--------- GETx ID
	@Operation(summary = "Get a message by id", description = "Return a message", responses = {
		@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Message.class))),
		@ApiResponse(responseCode = "400", description = "Invalid id supplied"),
		@ApiResponse(responseCode = "404", description = "Message not found") }
	)
	@GetMapping(value = "/{id}", produces = { "application/json" })
	ResponseEntity<Message> getById(@Parameter(description = "Id of message to return", required = true) @PathVariable("id") Long id);


	//--------- PUT
	@Operation(summary = "Adds a message", description = "Add a message", responses = {
		@ApiResponse(responseCode = "200", description = "Successful operation"),
		@ApiResponse(responseCode = "400", description = "Invalid data"),
		@ApiResponse(responseCode = "409", description = "Already exists") }
	)
	@PutMapping(value = "", produces = { "application/json" })
	ResponseEntity<Void> add(@Parameter(description = "Message to add", required = true) @RequestBody Message message);



    //---- DELTE 
	@Operation(summary = "Deletes a message by id", description = "Delete a message", responses = {
		@ApiResponse(responseCode = "200", description = "Successful operation"),
		@ApiResponse(responseCode = "400", description = "Invalid id supplied"),
		@ApiResponse(responseCode = "404", description = "Message not found") }
	)
	@DeleteMapping(value = "/{id}", produces = { "application/json" })
	ResponseEntity<Void> deleteById(@Parameter(description = "Id of message to delete", required = true) @PathVariable("id") Long id);
}
