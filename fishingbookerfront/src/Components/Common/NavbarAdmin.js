import React from "react";
import { Nav, Navbar, NavbarBrand, NavDropdown, Table } from "react-bootstrap";
import logo from "../../Assets/img/logo.jpg";

export default function NavbarAdmin() {
  return (
    <Navbar bg="dark" variant="dark" sticky="top">
      <NavbarBrand className="brand" expand="lg">
        <img src={logo} height="30px" width="50px" margin="auto" />
        FishingBooker
      </NavbarBrand>
      <Navbar.Toggle className="coloring" />
      <Nav>
        <Nav.Link href="/adminHomePage">Home Page</Nav.Link>

        <NavDropdown title="Entities">
          <NavDropdown.Item href="/allInstructors">
            Instructors
          </NavDropdown.Item>

          <NavDropdown.Item href="/fishingClasses">
            Fishing Classes
          </NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item href="/allBoatOwners">Boat owners</NavDropdown.Item>

          <NavDropdown.Item href="/allBoats">Boats</NavDropdown.Item>
          <NavDropdown.Item href="/allCottageOwners">
            Cottage owners
          </NavDropdown.Item>

          <NavDropdown.Item href="/allCottages">Cottages</NavDropdown.Item>
        </NavDropdown>

        <NavDropdown title="Requests">
          <NavDropdown.Item href="/requests">Registration</NavDropdown.Item>

          <NavDropdown.Item href="/deleteRequests">Delete</NavDropdown.Item>
          <NavDropdown.Item href="/rateRequests">Rate</NavDropdown.Item>

          <NavDropdown.Item href="/complaintRequests">
            Complaint
          </NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item href="/reportRequests">Report</NavDropdown.Item>
        </NavDropdown>

        <NavDropdown title="Loyalty">
          <NavDropdown.Item href="/definePoints">
            Define loyalty points
          </NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item href="/createLoyaltyCategory">
            Create loyalty category
          </NavDropdown.Item>
        </NavDropdown>
        <Nav.Link href="login">Logout</Nav.Link>
      </Nav>
    </Navbar>
  );
}
