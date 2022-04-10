import React, { useState, useEffect } from "react";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import { Link } from "react-router-dom";
import PopupDelete from "./PopupDelete";

export default function DeleteRequests({
  instructorDeleteRequests,
  boatOwnerDeleteRequests,
  cottageOwnerDeleteRequests,
  adminDeleteRequests,
  clientDeleteRequests,
  removeInstructorHandler,
  removeInstructorDeleteRequestHandler,
}) {
  console.log("instructorDeleteRequests", instructorDeleteRequests);
  console.log("boatOwnerDeleteRequests", boatOwnerDeleteRequests);
  console.log("cottageOwnerDeleteRequests", cottageOwnerDeleteRequests);
  console.log("adminOwnerDeleteRequests", adminDeleteRequests);
  console.log("adminOwnerDeleteRequests", clientDeleteRequests);

  return (
    <div>
      <div className="header">
        {" "}
        <h1 style={{ textAlign: "center" }}> Instructor delete requests </h1>
      </div>
      {instructorDeleteRequests.map((instructorRequest) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {instructorRequest.name} {instructorRequest.surname}
                      </Card.Title>
                      <Card.Text>{instructorRequest.email}</Card.Text>
                      <Card.Text>
                        Biography: {instructorRequest.shortBiography}
                      </Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {instructorRequest.address},{" "}
                        {instructorRequest.city}, {instructorRequest.country}
                      </ListGroupItem>
                      <ListGroupItem>
                        Phone number: {instructorRequest.number}
                      </ListGroupItem>

                      <ListGroupItem>
                        Explanation of registration:{" "}
                        {instructorRequest.explanation}
                      </ListGroupItem>
                      <ListGroupItem>
                        Reason for deletion: {instructorRequest.deleteReason}
                      </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <PopupDelete
                        removeInstructorHandler={removeInstructorHandler}
                        instructorRequest={instructorRequest}
                        removeInstructorDeleteRequestHandler={
                          removeInstructorDeleteRequestHandler
                        }
                      ></PopupDelete>
                    </Card.Body>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
      <div className="header">
        {" "}
        <h1 style={{ textAlign: "center" }}> Boat owner delete requests </h1>
      </div>
      {boatOwnerDeleteRequests.map((boatOwnerRequest) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {boatOwnerRequest.name} {boatOwnerRequest.surname}
                      </Card.Title>
                      <Card.Text>{boatOwnerRequest.email}</Card.Text>
                      <Card.Text>
                        Biography: {boatOwnerRequest.shortBiography}
                      </Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {boatOwnerRequest.address},{" "}
                        {boatOwnerRequest.city}, {boatOwnerRequest.country}
                      </ListGroupItem>
                      <ListGroupItem>
                        Phone number: {boatOwnerRequest.number}
                      </ListGroupItem>

                      <ListGroupItem>
                        Explanation of registration:{" "}
                        {boatOwnerRequest.explanation}
                      </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <Button
                        style={{ width: "8rem" }}
                        variant="outline-success"
                      >
                        Accept
                      </Button>

                      <PopupDelete></PopupDelete>
                    </Card.Body>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
      <div className="header">
        {" "}
        <h1 style={{ textAlign: "center" }}> Cottage owner delete requests </h1>
      </div>
      {cottageOwnerDeleteRequests.map((cottageOwnerRequest) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {cottageOwnerRequest.name} {cottageOwnerRequest.surname}
                      </Card.Title>
                      <Card.Text>{cottageOwnerRequest.email}</Card.Text>
                      <Card.Text>
                        Biography: {cottageOwnerRequest.shortBiography}
                      </Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {cottageOwnerRequest.address},{" "}
                        {cottageOwnerRequest.city},{" "}
                        {cottageOwnerRequest.country}
                      </ListGroupItem>
                      <ListGroupItem>
                        Phone number: {cottageOwnerRequest.number}
                      </ListGroupItem>

                      <ListGroupItem>
                        Explanation of registration:{" "}
                        {cottageOwnerRequest.explanation}
                      </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <Button
                        style={{ width: "8rem" }}
                        variant="outline-success"
                      >
                        Accept
                      </Button>

                      <PopupDelete></PopupDelete>
                    </Card.Body>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
      <div className="header">
        {" "}
        <h1 style={{ textAlign: "center" }}> Admin delete requests </h1>
      </div>
      {adminDeleteRequests.map((adminRequest) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {adminRequest.name} {adminRequest.surname}
                      </Card.Title>
                      <Card.Text>{adminRequest.email}</Card.Text>
                      <Card.Text>
                        Biography: {adminRequest.shortBiography}
                      </Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {adminRequest.address}, {adminRequest.city},{" "}
                        {adminRequest.country}
                      </ListGroupItem>
                      <ListGroupItem>
                        Phone number: {adminRequest.number}
                      </ListGroupItem>

                      <ListGroupItem>
                        Explanation of registration: {adminRequest.explanation}
                      </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <Button
                        style={{ width: "8rem" }}
                        variant="outline-success"
                      >
                        Accept
                      </Button>

                      <PopupDelete></PopupDelete>
                    </Card.Body>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
      <div className="header">
        {" "}
        <h1 style={{ textAlign: "center" }}> Client delete requests </h1>
      </div>
      {clientDeleteRequests.map((clientRequest) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {clientRequest.name} {clientRequest.surname}
                      </Card.Title>
                      <Card.Text>{clientRequest.email}</Card.Text>
                      <Card.Text>
                        Biography: {clientRequest.shortBiography}
                      </Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {clientRequest.address}, {clientRequest.city},{" "}
                        {clientRequest.country}
                      </ListGroupItem>
                      <ListGroupItem>
                        Phone number: {clientRequest.number}
                      </ListGroupItem>

                      <ListGroupItem>
                        Explanation of registration: {clientRequest.explanation}
                      </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <Button
                        style={{ width: "8rem" }}
                        variant="outline-success"
                      >
                        Accept
                      </Button>

                      <PopupDelete></PopupDelete>
                    </Card.Body>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
}
