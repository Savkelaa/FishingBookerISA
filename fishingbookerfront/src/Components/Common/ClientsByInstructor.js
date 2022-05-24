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

export default function ClientsByInstructor({
  clientsByInstructor,
  clientsByInstructorQuick,
}) {
  console.log("clientsByInstructor", clientsByInstructor);
  console.log("clientsByInstructorQuick", clientsByInstructorQuick);

  const key = "id";
  const clientsByInstructorUnique = [
    ...new Map(clientsByInstructor.map((item) => [item[key], item])).values(),
  ];
  const clientsByInstructorQuickUnique = [
    ...new Map(
      clientsByInstructorQuick.map((item) => [item[key], item])
    ).values(),
  ];

  console.log("clientsByInstructorUnique", clientsByInstructorUnique);

  return (
    <div>
      <div className="header">
        <h2 style={{ textAlign: "center" }}>
          {" "}
          All my clients whose reservations have been completed{" "}
        </h2>
      </div>
      {clientsByInstructorUnique.map((client) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {client.name} {client.surname}
                      </Card.Title>
                      <Card.Text>{client.email}</Card.Text>
                      <Card.Text>Penalties: {client.penalty}</Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {client.address}, {client.city},{" "}
                        {client.country}
                      </ListGroupItem>
                      <ListGroupItem>
                        Phone number: {client.number}
                      </ListGroupItem>

                      <ListGroupItem>
                        Explanation of registration: {client.explanation}
                      </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <Link to={`/instructorCreateReport/${client.id}`}>
                        <Button>report / comment / praise</Button>
                      </Link>
                    </Card.Body>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
      <div className="header">
        <h2 style={{ textAlign: "center" }}>
          {" "}
          All my clients whose quick reservations have been completed{" "}
        </h2>
      </div>
      {clientsByInstructorQuickUnique.map((client) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {client.name} {client.surname}
                      </Card.Title>
                      <Card.Text>{client.email}</Card.Text>
                      <Card.Text>Penalties: {client.penalty}</Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {client.address}, {client.city},{" "}
                        {client.country}
                      </ListGroupItem>
                      <ListGroupItem>
                        Phone number: {client.number}
                      </ListGroupItem>

                      <ListGroupItem>
                        Explanation of registration: {client.explanation}
                      </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <Link to={`/instructorCreateReport/${client.id}`}>
                        <Button>report / comment / praise</Button>
                      </Link>
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
