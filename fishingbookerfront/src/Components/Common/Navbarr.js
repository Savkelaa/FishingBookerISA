import React from "react";
import { Nav, Navbar, NavbarBrand, NavDropdown, Table } from "react-bootstrap";
import logo from "../../Assets/img/logo.jpg";

export default function Navbarr() {
  return (
    <Navbar bg="dark" variant="dark" sticky="top">
      <NavbarBrand className="brand" expand="lg">
        <img src={logo} height="30px" width="50px" margin="auto" />
        FishingBooker
      </NavbarBrand>
      <Navbar.Toggle className="coloring" />
      <Nav>
        <NavDropdown title="Products">
          <NavDropdown.Item href="#products/tea">Tea</NavDropdown.Item>
          <NavDropdown.Item href="#products/coffee">Coffee</NavDropdown.Item>
          <NavDropdown.Item href="#products/chocolate">
            Chocolate
          </NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item href="#products/promo">Promo</NavDropdown.Item>
        </NavDropdown>
        <Nav.Link href="#blog">Blog</Nav.Link>
        <Nav.Link href="#about-us">About Us</Nav.Link>
        <Nav.Link href="#contact-us">Contact Us</Nav.Link>
      </Nav>
    </Navbar>
  );
}
