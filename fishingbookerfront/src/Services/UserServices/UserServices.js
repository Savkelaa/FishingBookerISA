const axios = require("axios");

const userServices = {
  signUpUser: (user) => {
    return axios.post(`${process.env.REACT_APP_API_URL}/signup/async`, user);
  },
  createClient: (client) => {
    return axios.post(`${process.env.REACT_APP_API_URL}clients`, client);
  },
  createCottageOwner: (cottageOwner) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}cottageOwners`,
      cottageOwner
    );
  },
  createInstructor: (instrictor) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}instructors`,
      instrictor
    );
  },
  createBoatOwner: (boatOwner) => {
    return axios.post(`${process.env.REACT_APP_API_URL}boatOwners`, boatOwner);
  },

  getAllInstructors: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}instructors`);
  },

  getAllCottageOwners: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}cottageOwners`);
  },

  getAllBoatOwners: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}boatOwners`);
  },

  getAllInstructorRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}instructorRequests`);
  },
  getAllCottageOwnerRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}cottageOwnerRequests`);
  },
  getAllBoatOwnerRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}boatOwnerRequests`);
  },

  activateCottageOwner: (cottageOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}activateCottageOwner/${cottageOwner.id}`
    );
  },
  removeCottageOwner: (cottageOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}removeCottageOwner/${cottageOwner.id}`,
      cottageOwner
    );
  },
  activateBoatOwner: (boatOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}activateBoatOwner/${boatOwner.id}`
    );
  },
  removeBoatOwner: (boatOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}removeBoatOwner/${boatOwner.id}`,
      boatOwner
    );
  },
  activateInstructor: (instructor) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}activateInstructor/${instructor.id}`
    );
  },
  removeInstructor: (instructor) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}removeInstructor/${instructor.id}`,
      instructor
    );
  },

  ///// zahtevi za slanje rikvestova za brisanje
  instructorSendDeleteRequest: (instructor) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}instructorSendDeleteRequest/${instructor.id}`,
      instructor
    );
  },
  cottageOwnerSendDeleteRequest: (cottageOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}cottageOwnerSendDeleteRequest/${cottageOwner.id}`,
      cottageOwner
    );
  },
  boatOwnerSendDeleteRequest: (boatOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}boatOwnerSendDeleteRequest/${boatOwner.id}`,
      boatOwner
    );
  },
  adminSendDeleteRequest: (admin) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}adminSendDeleteRequest/${admin.id}`,
      admin
    );
  },
  clientSendDeleteRequest: (client) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}clientSendDeleteRequest/${client.id}`,
      client
    );
  },

  ///Dobavljanje svih zahteva za brisanje
  getAllInstructorDeleteRequests: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}instructorDeleteRequests`
    );
  },
  getAllCottageOwnerDeleteRequests: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottageOwnerDeleteRequests`
    );
  },
  getAllBoatOwnerDeleteRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}boatOwnerDeleteRequests`);
  },
  getAllAdminDeleteRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}adminDeleteRequests`);
  },
  getAllClientDeleteRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}clientDeleteRequests`);
  },
};

export default userServices;
