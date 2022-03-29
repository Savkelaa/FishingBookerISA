import React, { useState, useEffect } from "react";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import { Link } from "react-router-dom";
import Popup from "./Popup";

export default function BoatOwners({ boatOwners }) {
  console.log("boatOwners", boatOwners);

  return (
    <div>
      <div className="header">
        <h1 style={{ textAlign: "center" }}> All boat owners </h1>
      </div>
      {boatOwners.map((boatOwner) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {boatOwner.name} {boatOwner.surname}
                      </Card.Title>
                      <Card.Text>{boatOwner.email}</Card.Text>
                      <Card.Text>Biography: {boatOwner.biography}</Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {boatOwner.address}, {boatOwner.city},{" "}
                        {boatOwner.country}
                      </ListGroupItem>
                      <ListGroupItem>
                        Phone number: {boatOwner.number}
                      </ListGroupItem>

                      <ListGroupItem>
                        Explanation of registration: {boatOwner.explanation}
                      </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <Button
                        style={{ width: "8rem" }}
                        variant="outline-success"
                      >
                        More Details
                      </Button>
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
