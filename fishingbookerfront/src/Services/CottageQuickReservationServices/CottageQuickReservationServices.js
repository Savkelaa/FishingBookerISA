const axios = require("axios");

const cottageQuickReservationServices = {

    getAllCottageQuickReservationsByOwner: (ownerId) => {
        return axios.get(
        `${process.env.REACT_APP_API_URL}cottageQuickReservationsByOwner?cottageOwnerId=${ownerId}`
        );
    },

    getAllCottageReservationsByClient: (clientId) => {
        return axios.get(
          `${process.env.REACT_APP_API_URL}cottageReservationsClient?clientId=${clientId}`
        );
    },
    
    createCottageQuickReservationAction: (cottageAction) => {
        return axios.post(
            `${process.env.REACT_APP_API_URL}cottageQuickReservations`,
        cottageAction
        );
    }
};

export default cottageQuickReservationServices;