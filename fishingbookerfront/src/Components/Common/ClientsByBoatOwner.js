import React, { useState, useEffect, useRef } from "react";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import { Link } from "react-router-dom";
import Popup from "./Popup";

export default function ClientsByBoatOwner({
  clientsByBoatOwner,
  clientsByBoatOwnerQuick,
  changeFilterClientsText,
}) {
  console.log("clientsByBoatOwner", clientsByBoatOwner);
  console.log("clientsByBoatOwnerQuick", clientsByBoatOwnerQuick);

  const key = "id";
  const clientsByBoatOwnerUnique = [
    ...new Map(clientsByBoatOwner.map((item) => [item[key], item])).values(),
  ];
  const clientsByBoatOwnerQuickUnique = [
    ...new Map(
      clientsByBoatOwnerQuick.map((item) => [item[key], item])
    ).values(),
  ];

  console.log("clientsByBoatOwnerUnique", clientsByBoatOwnerUnique);
  const search = useRef("");
  return (
    <div>
      <input
        ref={search}
        type="search"
        className="form-control"
        name="search-fishingClass"
        placeholder="Search clients by name.."
        onKeyUp={(e) => changeFilterClientsText(search.current.value)}
      ></input>
      <div className="header">
        <h2 style={{ textAlign: "center" }}>
          {" "}
          All my clients whose reservations have been completed{" "}
        </h2>
      </div>
      {clientsByBoatOwnerUnique.map((client) => (
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
                      <Link to={`/boatOwnerCreateReport/${client.id}`}>
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
      {clientsByBoatOwnerQuickUnique.map((client) => (
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
                      <Link to={`/boatOwnerCreateReport/${client.id}`}>
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
