FROM mcr.microsoft.com/dotnet/sdk:6.0
WORKDIR /src
COPY ["backend.csproj", ""]
RUN dotnet restore "./backend.csproj"
COPY . .
EXPOSE 12345
RUN dotnet dev-certs https --trust
ENTRYPOINT dotnet watch run