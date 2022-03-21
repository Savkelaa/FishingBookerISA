import React from "react";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import { Link } from "react-router-dom";

export default function Request({
  instructorRequests,
  boatOwnerRequests,
  cottageOwnerRequest,
}) {
  console.log("instructorRequests", instructorRequests);
  console.log("boatOwnerRequests", boatOwnerRequests);
  console.log("cottageOwnerRequest", cottageOwnerRequest);
  return <div>Request</div>;
}
