using System;
using Microsoft.EntityFrameworkCore.Migrations;
using Npgsql.EntityFrameworkCore.PostgreSQL.Metadata;

#nullable disable

namespace backend.Migrations
{
    public partial class InitialCreate : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "candidates",
                columns: table => new
                {
                    id = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    identification = table.Column<string>(type: "text", nullable: false),
                    issue_date = table.Column<DateTime>(type: "timestamp with time zone", nullable: false),
                    issue_place = table.Column<string>(type: "text", nullable: false),
                    email = table.Column<string>(type: "text", nullable: false),
                    first_name = table.Column<string>(type: "text", nullable: false),
                    last_name = table.Column<string>(type: "text", nullable: false),
                    gender = table.Column<string>(type: "text", nullable: false),
                    date_of_birth = table.Column<DateTime>(type: "timestamp with time zone", nullable: false),
                    place_of_birth = table.Column<string>(type: "text", nullable: false),
                    phone = table.Column<string>(type: "text", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_candidates", x => x.id);
                });

            migrationBuilder.CreateTable(
                name: "examinations",
                columns: table => new
                {
                    id = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    name = table.Column<string>(type: "text", nullable: false),
                    date = table.Column<DateTime>(type: "timestamp with time zone", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_examinations", x => x.id);
                });

            migrationBuilder.CreateTable(
                name: "supervisors",
                columns: table => new
                {
                    id = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    name = table.Column<string>(type: "text", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_supervisors", x => x.id);
                });

            migrationBuilder.CreateTable(
                name: "registration_forms",
                columns: table => new
                {
                    id = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    candidate_id = table.Column<int>(type: "integer", nullable: false),
                    examination_id = table.Column<int>(type: "integer", nullable: false),
                    level = table.Column<string>(type: "text", nullable: false),
                    status = table.Column<bool>(type: "boolean", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_registration_forms", x => x.id);
                    table.ForeignKey(
                        name: "FK_registration_forms_candidates_candidate_id",
                        column: x => x.candidate_id,
                        principalTable: "candidates",
                        principalColumn: "id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_registration_forms_examinations_examination_id",
                        column: x => x.examination_id,
                        principalTable: "examinations",
                        principalColumn: "id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "rooms",
                columns: table => new
                {
                    id = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    name = table.Column<string>(type: "text", nullable: false),
                    examination_id = table.Column<int>(type: "integer", nullable: false),
                    level = table.Column<string>(type: "text", nullable: false),
                    time = table.Column<bool>(type: "boolean", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_rooms", x => x.id);
                    table.ForeignKey(
                        name: "FK_rooms_examinations_examination_id",
                        column: x => x.examination_id,
                        principalTable: "examinations",
                        principalColumn: "id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "candidate_rooms",
                columns: table => new
                {
                    id = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    candidate_id = table.Column<int>(type: "integer", nullable: false),
                    candidate_no = table.Column<string>(type: "text", nullable: false),
                    room_id = table.Column<int>(type: "integer", nullable: false),
                    score_listening = table.Column<float>(type: "real", nullable: false),
                    score_speaking = table.Column<float>(type: "real", nullable: false),
                    score_writing = table.Column<float>(type: "real", nullable: false),
                    score_reading = table.Column<float>(type: "real", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_candidate_rooms", x => x.id);
                    table.ForeignKey(
                        name: "FK_candidate_rooms_candidates_candidate_id",
                        column: x => x.candidate_id,
                        principalTable: "candidates",
                        principalColumn: "id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_candidate_rooms_rooms_room_id",
                        column: x => x.room_id,
                        principalTable: "rooms",
                        principalColumn: "id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "supervisor_rooms",
                columns: table => new
                {
                    id = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    supervisor_id = table.Column<int>(type: "integer", nullable: false),
                    room_id = table.Column<int>(type: "integer", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_supervisor_rooms", x => x.id);
                    table.ForeignKey(
                        name: "FK_supervisor_rooms_rooms_room_id",
                        column: x => x.room_id,
                        principalTable: "rooms",
                        principalColumn: "id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_supervisor_rooms_supervisors_supervisor_id",
                        column: x => x.supervisor_id,
                        principalTable: "supervisors",
                        principalColumn: "id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_candidate_rooms_candidate_id",
                table: "candidate_rooms",
                column: "candidate_id");

            migrationBuilder.CreateIndex(
                name: "IX_candidate_rooms_room_id",
                table: "candidate_rooms",
                column: "room_id");

            migrationBuilder.CreateIndex(
                name: "IX_registration_forms_candidate_id",
                table: "registration_forms",
                column: "candidate_id");

            migrationBuilder.CreateIndex(
                name: "IX_registration_forms_examination_id",
                table: "registration_forms",
                column: "examination_id");

            migrationBuilder.CreateIndex(
                name: "IX_rooms_examination_id",
                table: "rooms",
                column: "examination_id");

            migrationBuilder.CreateIndex(
                name: "IX_supervisor_rooms_room_id",
                table: "supervisor_rooms",
                column: "room_id");

            migrationBuilder.CreateIndex(
                name: "IX_supervisor_rooms_supervisor_id",
                table: "supervisor_rooms",
                column: "supervisor_id");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "candidate_rooms");

            migrationBuilder.DropTable(
                name: "registration_forms");

            migrationBuilder.DropTable(
                name: "supervisor_rooms");

            migrationBuilder.DropTable(
                name: "candidates");

            migrationBuilder.DropTable(
                name: "rooms");

            migrationBuilder.DropTable(
                name: "supervisors");

            migrationBuilder.DropTable(
                name: "examinations");
        }
    }
}
