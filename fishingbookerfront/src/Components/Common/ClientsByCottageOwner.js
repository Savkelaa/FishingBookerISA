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

export default function ClientsByCottageOwner({
  clientsByCottageOwner,
  clientsByCottageOwnerQuick,
  changeFilterClientsText,
}) {
  console.log("clientsByCottageOwner", clientsByCottageOwner);
  console.log("clientsByCottageOwnerQuick", clientsByCottageOwnerQuick);

  const key = "id";
  const clientsByCottageOwnerUnique = [
    ...new Map(clientsByCottageOwner.map((item) => [item[key], item])).values(),
  ];
  const clientsByCottageOwnerQuickUnique = [
    ...new Map(
      clientsByCottageOwnerQuick.map((item) => [item[key], item])
    ).values(),
  ];

  console.log("clientsByCottageOwnerUnique", clientsByCottageOwnerUnique);
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
      {clientsByCottageOwnerUnique.map((client) => (
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
                      <Link to={`/cottageOwnerCreateReport/${client.id}`}>
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
      {clientsByCottageOwnerQuickUnique.map((client) => (
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
                      <Link to={`/cottageOwnerCreateReport/${client.id}`}>
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
