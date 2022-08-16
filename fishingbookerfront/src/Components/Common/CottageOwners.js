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

export default function CottageOwners({
  cottageOwners,
  updateCottageOwnerHandler,
}) {
  console.log("cottageOwners", cottageOwners);

  return (
    <div>
      <div className="header">
        <h1 style={{ textAlign: "center" }}> All cottage owners </h1>
      </div>
      {cottageOwners.map((cottageOwner) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {cottageOwner.name} {cottageOwner.surname}
                      </Card.Title>
                      <Card.Text>{cottageOwner.email}</Card.Text>
                      <Card.Text>Biography: {cottageOwner.biography}</Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {cottageOwner.address}, {cottageOwner.city},{" "}
                        {cottageOwner.country}
                      </ListGroupItem>
                      <ListGroupItem>
                        Phone number: {cottageOwner.number}
                      </ListGroupItem>

                      <ListGroupItem>
                        Explanation of registration: {cottageOwner.explanation}
                      </ListGroupItem>
                    </ListGroup>
                   
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
